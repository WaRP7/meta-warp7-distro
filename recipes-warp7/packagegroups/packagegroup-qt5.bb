DESCRIPTION = "Qt5 for Embedded Linux (Qt without X11)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = " \
	qtbase \
	qtbase-tools \
	qtbase-plugins \
	qtserialport \
	qtserialbus \
	qtconnectivity \
"
