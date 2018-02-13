setenv bootargs 'console=${console},${baudrate} root=${mender_kernel_root} rootwait rw'
run mender_setup
mmc dev ${mender_uboot_dev}

setenv kernel_addr_r 0x80800000
setenv fdt_addr 0x83000000
setenv bootdir /boot
setenv fdt_file imx7s-warp.dtb
setenv image zImage

echo reading ${image} ...
load ${mender_uboot_root} ${kernel_addr_r} ${bootdir}/${image}
echo reading ${fdt_file} ...
load ${mender_uboot_root} ${fdt_addr} ${bootdir}/${fdt_file}

bootz ${kernel_addr_r} - ${fdt_addr}
run mender_try_to_recover
