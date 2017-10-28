SUMMARY = "Qt App to test Air Quality 2 click with RPMSG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/Jeanrenet/ServiceRPMSG;protocol=git \
	file://init-service-rpmsg.init \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase qtserialport"

INSANE_SKIP_${PN} += "installed-vs-shipped"

inherit qmake5 update-rc.d

do_install_append() {
		
        install -d ${D}${sysconfdir}/init.d/
        
        install -m 0755 ${WORKDIR}/init-service-rpmsg.init ${D}${sysconfdir}/init.d/init-service-rpmsg
}

INITSCRIPT_NAME = "init-service-rpmsg"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

FILE_${PN} = "${datadir}/*"
