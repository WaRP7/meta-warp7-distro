DESCRIPTION = "Tools i/o Package Group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

RDEPENDS_${PN} = " \
    i2c-tools \
    iotop \
    devmem2 \
    evtest \
    spitools \
    modbus-rtu \
    "
