DESCRIPTION = "Tools i/o Package Group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS_${PN} = " \
	i2c-tools \
    	devmem2 \
    	evtest \
    	spitools \
    	modbus-rtu \
	service-mpl3115 \
	rpmsg-tools \
    "
