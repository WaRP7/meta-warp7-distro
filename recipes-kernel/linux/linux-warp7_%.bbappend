FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://0001-Doc-DT-Add-binding-document-for-GPIO-exporter.patch \
	file://0002-gpio-add-driver-to-export-DT-configured-GPIOs-to-use.patch \
	file://0003-Add-imx7s-warp-modbus.dts-modbus-example.patch \
	file://0004-Add-m4-support.patch \
	file://0005-Add-m4-support-and-modbus-example.patch \
	file://ARM-imx-Add-imx7s-warp-RPMsg-support.patch \
	"
