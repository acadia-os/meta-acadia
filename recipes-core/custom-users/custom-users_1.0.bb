SUMMARY = "Add soccentric account to the system"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
    install -d ${D}/home/soccentric
    install -d ${D}/etc/sudoers.d

    # Create a new user account
    useradd -m -s /bin/bash soccentric

    # Set a password for the new user
    echo "soccentric:soccentric" | chpasswd

    # Add the new user to the sudo group
    echo "soccentric ALL=(ALL) ALL" > ${D}/etc/sudoers.d/soccentric

    # Set the correct ownership and permissions for the home directory
    chown soccentric:soccentric ${D}/home/soccentric
    chmod 700 ${D}/home/soccentric
}

FILES_${PN} += "/home/soccentric /etc/sudoers.d/soccentric"
