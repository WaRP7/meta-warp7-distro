FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://0001-warp7-added-mender-requirements.patch \
	file://fw_env.config \
"

MENDER_UBOOT_AUTO_CONFIGURE = "0"
BOOTENV_SIZE = "0x2000"
