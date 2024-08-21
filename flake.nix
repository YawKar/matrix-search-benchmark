{
  description = "matrix-search-benchmark";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { /*self,*/ nixpkgs, flake-utils, ... }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;
          config.allowUnfree = true;
        };
      in
      {
        devShells.default = pkgs.mkShell {
          buildInputs = [
            pkgs.temurin-bin-21
          ];
          shellHook = ''
            export PS1="(matrix-search-benchmark)$PS1"
          '';
        };
      }
    );
}

