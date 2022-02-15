{ nixpkgs ? import <nixpkgs> {} }:

let
  pkgs = import (builtins.fetchTarball "channel:nixpkgs-unstable") {};
  pythonEnv = pkgs.python310.withPackages (p: with p; [
    pylint
    ipython
    notebook

    numpy
    matplotlib
    pandas
  ]);

in pkgs.mkShell {
  buildInputs = [
    pkgs.gcc
    pythonEnv
  ];

  PYTHONPATH = "${pythonEnv}/bin/python";
}
