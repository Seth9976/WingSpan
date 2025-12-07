// 函数: sub_49e8fc
// 地址: 0x49e8fc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
char* x8_1 = *arg1

if (arg1[1] == x8_1)
label_49e950:
    void* x0_3 = sub_495970(arg1)
    
    if (*(x21 + 0x28) == x8)
        return x0_3
else
    uint32_t x8_2 = zx.d(*x8_1)
    void* x0_1
    
    if (x8_2 != 0x44)
        if (x8_2 != 0x54)
            goto label_49e950
        
        x0_1 = sub_49615c(arg1)
        goto label_49e974
    
    x0_1 = sub_496500(arg1)
label_49e974:
    void* var_40 = x0_1
    
    if (x0_1 != 0)
        sub_4953d4(&arg1[0x25], &var_40)
    
    if (*(x21 + 0x28) == x8)
        return x0_1

__stack_chk_fail()
noreturn
