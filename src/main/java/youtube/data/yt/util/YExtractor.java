package youtube.data.yt.util;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import youtube.data._yt_player.YtPlayer;
import youtube.data.yt.core.Decipher;
import youtube.data.niche.VideoInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @description the YExtractor
 */
public class YExtractor {
	private static HashMap<String, String> deciphers = new HashMap<String, String>();
    /**
	 * 
	 * @param videoInfo
	 * @return VideoInfo return the videoInfo
	 * @throws UnsupportedEncodingException
	 */
	public static VideoInfo parseVideoInfo(String videoInfo) throws UnsupportedEncodingException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String[] a = URLDecoder.decode(videoInfo, "UTF-8").split("&");
		for (String y : a) {
			String[] z = y.split("=");
			if (z.length == 2) {
				map.put(z[0], z[1].replace('+', ' '));
			} else {
				List<String> q = Arrays.asList(z);
				if (q.contains("player_response")) {
					String[] h = String.join("=", q).split("player_response=");
					map.put("player_response", JsonParser.parseString(URLDecoder.decode(h[1], "UTF-8")));
				}
			}

		}

		Type type = new TypeToken<VideoInfo>() {
		}.getType();
		return new GsonBuilder().disableHtmlEscaping().create().fromJson(BHashMap.toJsonElement(map).toString(), type);
	}
    /**
	 * 
	 * @param playerInfo
	 * @return YtPlayer return the ytPlayer
	 */
	public static void parsePlayer(String playerInfo) {
		Pattern p = Pattern
				.compile("\\/s\\/player\\/[a-zA-Z0-9]{1,}\\/[(a-zA-z)\\.(a-zA-Z)]{1,}\\/[(a-zA-Z)\\_]{1,}\\/base.js");
		Matcher m = p.matcher(playerInfo);
		if(m.find()){
			YtPlayer.setJsUrl(m.group(0));
			YtPlayer.setDecipher(Decipher.load(YtPlayer.getJsUrl()));
			
		}
	
	}
    /**
	 * 
	 * @param playerInfo
	 * @return List<String> return List<String> of decipher fn
	 */
	public static List<String> parsePlayerDecipher(String playerInfo) {

		Pattern ytSlice = Pattern.compile(
				"[a-zA-Z0-9]{1,}\\:function\\([a-zA-Z0-9]{1,}\\,[a-zA-Z0-9]{1,}\\)\\{[a-zA-Z0-9]{1,}\\.splice\\([0-9]{1}\\,[a-zA-Z0-9]{1,}\\)\\}");
		Matcher b = ytSlice.matcher(playerInfo);
		if(b.find()){
			
			deciphers.put(b.group(0).split(":")[0], "Bx");
		}
		
		Pattern ytShift = Pattern.compile(
				"[a-zA-Z0-9]{1,}\\:function\\([a-zA-Z0-9]{1,}\\,[a-zA-Z0-9]{1,}\\)\\{var [a-zA-Z]\\=[a-zA-Z0-9]\\[0\\]\\;[a-zA-Z0-9]\\[0\\]\\=[a-zA-Z0-9]\\[[a-zA-Z0-9]{1,}\\%[a-zA-Z0-9]{1,}\\.length\\]\\;[a-zA-Z0-9]\\[[a-zA-Z0-9]{1,}\\%[a-zA-Z0-9]{1,}\\.length\\]\\=[a-zA-Z0-9]{1,}\\}");
		Matcher c = ytShift.matcher(playerInfo);
		if(c.find()){
			
			deciphers.put(c.group(0).split(":")[0], "By");
		}

		Pattern ytReverse = Pattern.compile(
				"[a-zA-Z0-9]{1,}\\:function\\([a-zA-Z0-9]{1,}[\\,[a-zA-Z0-9]{1,}]{0,}\\)\\{[a-zA-Z0-9]{1,}\\.reverse\\(\\)\\}");
		Matcher d = ytReverse.matcher(playerInfo);

		if(d.find()){
			
			deciphers.put(d.group(0).split(":")[0], "Bz");
		}

		Pattern ytDecipher = Pattern.compile(
				"[a-zA-Z]{1,}=function\\([a-zA-Z]{1,}\\)\\{[a-zA-Z]{1,}\\=[a-zA-Z]{1,}\\.split\\(\"\"\\)\\;[[a-zA-Z]{1,}\\.[a-zA-Z]{1,}\\([a-zA-Z]{1,},[0-9]{1,}\\)\\;]{1,}return [a-zA-Z]{1,}\\.join\\(\"\"\\)\\}");
		Matcher a = ytDecipher.matcher(playerInfo);

		Pattern decipher = Pattern.compile("[a-zA-Z]{1,}=function\\([a-zA-Z]{1,}\\)\\{[a-zA-Z]{1,}\\=[a-zA-Z]{1,}\\.split\\(\"\"\\)\\;");
	        	String m="";
				if(a.find()){
				  Matcher h = decipher.matcher(a.group(0));
				   m = h.replaceAll("").replaceAll("return [a-zA-Z]{1,}\\.join\\(\"\"\\)\\}", "").replaceAll("[a-zA-Z0-9]{1,}\\.", "");
				}
		
		

		return Arrays.asList(m.split(";")).stream().map(YExtractor::decipherMap).collect(Collectors.toList());
		

	}
    /**
	 * 
	 * @param decipher
	 * @return String return String of transformed decipher fn
	 */
	private static String decipherMap(String decipher) {
		Pattern decipherp = Pattern.compile("\\([a-zA-Z0-9]{1,}\\,[0-9]{1,}\\)");
		Matcher matcher = decipherp.matcher(decipher);
		if(matcher.find()){
			return String.format(deciphers.get(decipher.replaceAll("\\([a-zA-Z0-9]{1,}\\,[0-9]{1,}\\)", "")) + "%s",
			matcher.group(0));
		}
		
		return decipher;
		
	}
    /**
	 * 
	 * @param sig signatureCipher
	 * @return String return the deciphered url
	 */
	public static String parseSignatureCipher(String sig) {

		List<String> s = Arrays.asList(sig.toString().split("&"));
		String url = s.stream().filter((String x) -> x.contains("url")).findAny().get();
		int indexOfUrl = s.indexOf(url);
		String[] signatureCipher = BList.swap(sig.toString().split("&"), 0, indexOfUrl);
		signatureCipher[indexOfUrl] = "sig=" + Decipher.decode(signatureCipher[indexOfUrl].replace("s=", ""));

		return String.join("&", signatureCipher);
	}

}
