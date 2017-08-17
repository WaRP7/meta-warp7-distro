SUMMARY = "U-boot bootloader fw_printenv/setenv utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
SECTION = "bootloader"
PROVIDES = "u-boot-fw-utils"
DEPENDS = "mtd-utils"

SRC_URI_append_imx7s-warp += "file://default-gcc.patch \
			      file://fw_env.config \				
				"

COMPATIBLE_MACHINE = "(imx7s-warp)"

S="${WORKDIR}/git"
PR = "r0"
PV = "v2017.03+git${SRCPV}"

SRCREV = "ac3b20cdbe5282fbfa46d7fd39358f5ee07e24d9"
SRCBRANCH = "2017.03+fslc"

SRC_URI = "git://github.com/Freescale/u-boot-fslc.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" V=1'

INSANE_SKIP_${PN} = "already-stripped"

inherit uboot-config

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake env
}

do_install () {
	install -d ${D}${base_sbindir}
	install -d ${D}${sysconfdir}
	install -d ${D}${libdir}
	
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
	install -m 0644 ${S}/tools/env/fw_env.config ${D}${sysconfdir}/fw_env.config
	install -m 644  ${S}/tools/env/lib.a ${D}${libdir}/libubootenv.a
}


PACKAGE_ARCH = "${MACHINE_ARCH}"
