SUMMARY = "Qt App to test Shared Memory and D-bus from ServiceRPMSG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/Jeanrenet/ServiceGateway;protocol=git \
	file://init-service-gateway.init \
	file://service-gateway.service \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase"

inherit qmake5 update-rc.d systemd

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init-service-gateway.init ${D}${sysconfdir}/init.d/init-service-gateway

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/service-gateway.service ${D}${systemd_unitdir}/system
}

INITSCRIPT_NAME = "init-service-gateway"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

SYSTEMD_SERVICE_${PN} = "service-gateway.service"
