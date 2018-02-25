FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://0001-Doc-DT-Add-binding-document-for-GPIO-exporter.patch \
	file://0002-gpio-add-driver-to-export-DT-configured-GPIOs-to-use.patch \
	file://0003-Add-imx7s-warp-modbus.dts-modbus-example.patch \
	file://0004-Add-m4-support.patch \
	file://0005-Add-m4-support-and-modbus-example.patch \
	file://ARM-imx-Add-imx7s-warp-RPMsg-support.patch \
	file://0001-WIP-add-LCD.patch \
	"


kernel_do_configure_prepend() {

    #systemd support
    kernel_conf_variable CGROUPS y
    kernel_conf_variable INOTIFY_USER y
    kernel_conf_variable SIGNALFD y
    kernel_conf_variable TIMERFD y
    kernel_conf_variable EPOLL y
    kernel_conf_variable NET y
    kernel_conf_variable SYSFS y
    kernel_conf_variable PROC_FS y
    kernel_conf_variable FHANDLE y
    kernel_conf_variable IPV6 y
    kernel_conf_variable AUTOFS4_FS y
    kernel_conf_variable TMPFS_POSIX_ACL y
    kernel_conf_variable TMPFS_POSIX_XATTR y
    kernel_conf_variable SECCOMP y
    kernel_conf_variable NET_NS y
    kernel_conf_variable DEVPTS_MULTIPLE_INSTANCES y

    #IIO interrupt and sysfs triggers
    kernel_conf_variable IIO_INTERRUPT_TRIGGER y
    kernel_conf_variable IIO_SYSFS_TRIGGER y

    #Namespaces support
    kernel_conf_variable NAMESPACES	y
}
