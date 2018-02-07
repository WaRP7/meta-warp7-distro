COMPATIBLE_MACHINE = "imx7s-warp"

PACKAGECONFIG_append = " libinput linuxfb fontconfig sql-sqlite no-opengl"
PACKAGECONFIG_remove = " icu examples tests gl gles2 eglfs"
