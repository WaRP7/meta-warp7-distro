DESCRIPTION = "airquality-click"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

SRC_URI = "https://libstock.mikroe.com/projects/download/2146/5381/1503230855_air_quality_2_cl_other_arm.zip "

S="${WORKDIR}/${PN}"

do_compile() {
        oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/airquality-2-click ${D}${bindir}
}

SRC_URI[md5sum] = "f9be952a73ea70d3a90488df559e53fc"
SRC_URI[sha256sum] = "b69637d594a84a9e405cf47e778cbf2eee9d57db4c1a8dcdebe4d82dc26df099"

# Avoid QA Issue: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags" 
