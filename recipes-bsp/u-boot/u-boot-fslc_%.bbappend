FILESEXTRAPATHS_prepend := "${THISDIR}/patches:"

SRC_URI += "\
	file://0001-warp7-update-defconfig-and-replace-fatload-command.patch \
	file://0002-warp7-update-location-zImage-dtb.patch \					
"
