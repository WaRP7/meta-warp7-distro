SUMMARY = "Qt App to test Mender scripts"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.1;md5=1a6d268fd218675ffea8be556788b780"

SRC_URI = " \
	git://github.com/texierp/mender-qt-updater \
	file://mender-qt-updater.service \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase"

INSANE_SKIP_${PN} += "installed-vs-shipped"

inherit qmake5 systemd

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/mender-qt-updater.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "mender-qt-updater.service"

FILE_${PN} = "${datadir}/*"
