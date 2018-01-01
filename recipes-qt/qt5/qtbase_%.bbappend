COMPATIBLE_MACHINE = "imx7s-warp"

PACKAGECONFIG_append = " libinput linuxfb fontconfig sql-sqlite"
PACKAGECONFIG_remove = " icu x11 opengl"
