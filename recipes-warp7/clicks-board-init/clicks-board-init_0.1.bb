DESCRIPTION = "GPIO init script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit update-rc.d

SRC_URI = " \
	file://mikrobus.sh \
"

do_install_append() {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/mikrobus.sh ${D}${sysconfdir}/init.d/
}

INITSCRIPT_NAME = "mikrobus.sh"
INITSCRIPT_PARAMS = "start 99 S ."
