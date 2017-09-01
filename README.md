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
$: repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b master
$ repo sync
```

At the end of the commands you have every metadata you need to start work with.

To start a simple image build :

```
$: cd sources
$: git clone -b master https://github.com/WaRP7/meta-warp7-distro.git
$: git clone -b master https://github.com/meta-qt5/meta-qt5.git
$: git clone -b master https://github.com/sbabic/meta-swupdate.git
$: MACHINE=imx7s-warp DISTRO=warp7 source setup-environment warp7-build/ 
... 
You can now run 'bitbake <target>' 

Common targets are: 
    core-image-minimal 
    meta-toolchain 
    meta-toolchain-sdk 
    adt-installer 
    meta-ide-support 

Your build environment has been configured with: 

    MACHINE=imx7s-warp 
    SDKMACHINE=i686 
    DISTRO=warp7 
    EULA=
    
``` 
Add layers to bblayers.conf

```  
$: bitbake-layers add-layer ../sources/meta-qt5/ 
$: bitbake-layers add-layer ../sources/meta-warp7-distro/
$: bitbake-layers add-layer ../sources/meta-swupdate/ 
$: bitbake-layers add-layer ../sources/meta-openembedded/meta-python/ 
$: bitbake-layers add-layer ../sources/meta-openembedded/meta-networking/
```
Finally
```  
$: bitbake qt5-image
```







