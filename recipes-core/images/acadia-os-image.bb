SUMMARY = "Your custom image for your machine"
DESCRIPTION = "A custom image that includes some additional packages and configurations."
LICENSE = "MIT"

inherit core-image


# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    openssh \
    nano \
    htop \
    your-custom-package \
"

IMAGE_INSTALL:append = " packagegroup-rpi-test"


IMAGE_ROOTFS_EXTRA_SPACE = "8192"

IMAGE_FEATURES += "ssh-server-dropbear"

export IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

do_rootfs[depends] += "your-custom-package:do_deploy"

ROOTFS_POSTPROCESS_COMMAND += "your_custom_post_process;"
