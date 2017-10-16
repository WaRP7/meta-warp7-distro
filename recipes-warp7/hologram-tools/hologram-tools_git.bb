SUMMARY = "Hologram tools (ppp)"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD;md5=3775480a712fc46a69647678acb234cb"

SRC_URI = " \
	git://github.com/hologram-io/hologram-tools;protocol=git \
	file://0001-change-baudrate-according-to-3G-SARA-Click.patch \
"

SRCREV = "8593eabcffd1ed629dcf74ca7149460048f7d48d"
S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
     
do_install() {
		
        install -d ${D}${sysconfdir}/ppp/peers
        install -d ${D}${sysconfdir}/chatscripts
        
        install -m 0644 ${S}/ppp/peers/iota ${D}${sysconfdir}/ppp/peers
        install -m 0644 ${S}/ppp/chatscripts/iota ${D}${sysconfdir}/chatscripts
}

