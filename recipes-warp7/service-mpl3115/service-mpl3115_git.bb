SUMMARY = "Qt App to test the mlp3115 with Dbus"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/texierp/ServiceMPL3115;protocol=git \
	file://init-service-mpl3115.init \
	file://service-mpl3115.service \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase"

INSANE_SKIP_${PN} += "installed-vs-shipped"

inherit qmake5 update-rc.d systemd

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init-service-mpl3115.init ${D}${sysconfdir}/init.d/init-service-mpl3115

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/service-mpl3115.service ${D}${systemd_unitdir}/system
}

INITSCRIPT_NAME = "init-service-mpl3115"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

SYSTEMD_SERVICE_${PN} = "service-mpl3115.service"

FILE_${PN} = "${datadir}/*"
