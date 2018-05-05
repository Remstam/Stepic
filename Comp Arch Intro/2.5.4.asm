# сложите значения в регистрах %eax и %edx
    # если произошло переполнение, то перейдите
    # к метке if_overflow (инструкции add и jc)
    add %eax, %edx
    jc if_overflow

    # иначе запишите в %eax 1 и перейдите к
    # к метке return (инструкции mov и jmp)
    mov $1, %eax
    jmp return

if_overflow:
    # запишите в %eax 0 (инструкция mov)
    mov $0, %eax
return: