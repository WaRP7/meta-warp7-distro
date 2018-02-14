require recipes-bsp/u-boot/u-boot-mender.inc
require u-boot-mender-warp7.inc

RPROVIDES_${PN} += "u-boot"
RDEPENDS_${PN}_append_imx7s-warp = " u-boot-scr"
