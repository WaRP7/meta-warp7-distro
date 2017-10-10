DESCRIPTION = "Simple command line tools to play with rpmsg"
AUTHOR = "Pierre-Jean Texier"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e8c1458438ead3c34974bc0be3a03ed6"

PR = "r0"

SRC_URI = "git://github.com/texierp/rpmsg-tools.git;protocol=git"

SRCREV = "${AUTOREV}"
S="${WORKDIR}/git"

do_compile() {
        oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/rpmsg-test ${D}${bindir}
}
