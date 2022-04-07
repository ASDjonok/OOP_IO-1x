{ nixpkgs ? builtins.fetchTarball "channel:nixpkgs-unstable"
, system ? null
}:

let
  pkgs = import nixpkgs ({
  } // (
    if (system != null)
      then { inherit system; }
      else {}
  ));

  pythonEnv = pkgs.python310.withPackages (p: with p; [
    pylint black
    ipython notebook
  ]);

in pkgs.mkShell {
  buildInputs = [
    pythonEnv
  ];

  PYTHONPATH = "${pythonEnv}/bin/python";
}
