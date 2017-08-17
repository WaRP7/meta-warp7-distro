FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://0001-Doc-DT-Add-binding-document-for-GPIO-exporter.patch \
	file://0002-gpio-add-driver-to-export-DT-configured-GPIOs-to-use.patch \
	file://0001-Add-imx7s-warp-modbus.dts-modbus-example.patch \
	"
	
KERNEL_DEVICETREE = " \
		imx7s-warp.dtb \
		imx7s-warp-modbus.dtb \
		"	
