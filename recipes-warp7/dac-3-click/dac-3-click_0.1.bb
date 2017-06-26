DESCRIPTION = "dac-3-click"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

SRC_URI = "http://libstock.mikroe.com/projects/download/2093/5209/1498487565_dac_3_clcik_other_arm.zip "

S="${WORKDIR}/${PN}"

do_compile() {
        oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/${PN} ${D}${bindir}
}

SRC_URI[md5sum] = "433f9b12f2aaa974834e8bfc2c8f3726"
SRC_URI[sha256sum] = "3178f830863d6e3c73bc652c540f756106c081def223a30edfe56463c2a9e99f"

# Avoid QA Issue: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags" 
