SUMMARY = "Qt App to test the mlp3115 with Dbus"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/texierp/ServiceMPL3115;protocol=git \
	file://init-service-mpl3115.init \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase"

INSANE_SKIP_${PN} += "installed-vs-shipped"

inherit qmake5 update-rc.d

do_install_append() {
		
        install -d ${D}${sysconfdir}/init.d/
        
        install -m 0755 ${WORKDIR}/init-service-mpl3115.init ${D}${sysconfdir}/init.d/init-service-mpl3115
}

INITSCRIPT_NAME = "init-service-mpl3115"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

FILE_${PN} = "${datadir}/*"
