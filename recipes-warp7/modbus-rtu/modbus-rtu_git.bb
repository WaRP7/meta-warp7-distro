SUMMARY = "Qt Modbus RTU Server"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/Jeanrenet/Warp7ModbusRTU;protocol=git \
	file://init-modbus-rtu-server.init \
	file://modbus-rtu.service \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase qtserialbus"

inherit qmake5 update-rc.d systemd

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init-modbus-rtu-server.init ${D}${sysconfdir}/init.d/init-modbus-rtu-server

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/modbus-rtu.service ${D}${systemd_unitdir}/system
}

INITSCRIPT_NAME = "init-modbus-rtu-server"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

SYSTEMD_SERVICE_${PN} = "modbus-rtu.service"
