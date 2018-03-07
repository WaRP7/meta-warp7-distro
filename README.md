# meta-warp7-distro

This README file contains information on building the meta-warp7-distro DISTRO layer.
Please see the corresponding sections below for details.

## Quick Start

To get the BSP you need to have repo installed and use it as:

1. Install the repo utility:
```
$: mkdir ~/bin
$: curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
$: chmod a+x ~/bin/repo
```

2. Download the BSP source:

```
$: PATH=${PATH}:~/bin
$: mkdir warp7_bsp
$: cd warp7_bsp
$: repo init -u https://github.com/texierp/yocto-warp7-bsp-repo -b master
$: repo sync -j8
```

At the end of the commands you have every metadata you need to start work with.

To start a simple image build :

```
$: MACHINE=imx7s-warp DISTRO=warp7 source setup-environment warp7-build/
...
Welcome to WaRP7 BSP !

You can now run 'bitbake <target>'

Common targets are:
	base-image
	qt5-image
	meta-toolchain-qt5

Your build environment has been configured with:

	MACHINE=imx7s-warp
	SDKMACHINE=i686
	DISTRO=warp7
	EULA=
    
``` 

Finally
```
$: bitbake qt5-image
```

or

```
$: bitbake base-image
```
