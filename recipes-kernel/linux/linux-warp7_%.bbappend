FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://0001-Doc-DT-Add-binding-document-for-GPIO-exporter.patch \
	file://0002-gpio-add-driver-to-export-DT-configured-GPIOs-to-use.patch \
	"
