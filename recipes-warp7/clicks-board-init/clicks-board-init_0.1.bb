DESCRIPTION = "GPIO init script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit update-rc.d systemd

SRC_URI = " \
	file://mikrobus.sh \
	file://init-mikrobus.sh \
	file://mikrobus.service \
"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/mikrobus.sh ${D}${sysconfdir}/init.d/

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/init-mikrobus.sh ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/mikrobus.service ${D}${systemd_unitdir}/system
}

INITSCRIPT_NAME = "mikrobus.sh"
INITSCRIPT_PARAMS = "start 99 S ."

SYSTEMD_SERVICE_${PN} = "mikrobus.service"
