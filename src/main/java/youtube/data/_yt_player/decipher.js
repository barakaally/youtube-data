var uy = {
    d8: function (a, b) {
      a.splice(0, b);
    },
    Wb: function (a, b) {
      var c = a[0];
      a[0] = a[b % a.length];
      a[b % a.length] = c;
    },
    Mg: function (a) {
      a.reverse();
    },
  };

  vy = function (a) {
    a = a.split("");
    uy.Mg(a, 55);
    uy.Wb(a, 27);
    uy.d8(a, 3);
    uy.Wb(a, 23);
    uy.Mg(a, 53);
    uy.Wb(a, 56);
    uy.Wb(a, 46);
    uy.Mg(a, 27);
    uy.d8(a, 1);
    return a.join("");
  };