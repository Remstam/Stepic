power:
    test %edx, %edx
    jz ret_zeropower
    mov %eax, %ebx
    for:
        dec %edx
        test %edx, %edx
        jz return

        imul %ebx, %eax
        jmp for
        
    return:
        mov %eax, %eax
        ret
    ret_zeropower:
        mov $1, %eax
        ret