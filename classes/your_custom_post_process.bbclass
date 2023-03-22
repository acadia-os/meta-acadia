def your_custom_post_process(d):
    import os
    rootfs = d.getVar("IMAGE_ROOTFS")

    # Your custom post-processing steps here

addtask your_custom_post_process after do_rootfs before do_image
