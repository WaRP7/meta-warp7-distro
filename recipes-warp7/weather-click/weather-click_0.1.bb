DESCRIPTION = "weather-click"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

SRC_URI = "https://libstock.mikroe.com/projects/download/2142/5369/1502734257_weather_click_other_arm.zip "

S="${WORKDIR}/${PN}"

do_compile() {
        oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/${PN} ${D}${bindir}
}

SRC_URI[md5sum] = "3590870177d25963fc4ccc13cee89100"
SRC_URI[sha256sum] = "6ab814f6bb5a5e9de6552daea4b0c0fe04b67756cdc5e76d8342c7828502b309"

# Avoid QA Issue: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags" 
