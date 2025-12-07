// 函数: sub_481f98
// 地址: 0x481f98
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_50 = 0
int64_t var_48 = 0
uint64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
uint64_t x20 = x0

if (x0 == 0)
    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
else
    int32_t x0_2 = sub_45be5c(arg1, &var_48, &var_50, 0, "java/lang/Object", "hashCode", 0x452601)
    char x0_6
    
    if ((x0_2 & 1) == 0)
        void var_40
        x20 = zx.q((*(*arg1 + 0x198))(arg1, x20, var_50, &var_40))
        x0_6 = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_2 & 1) != 0 || zx.d(x0_6) != 0)
        x20 = 0

if (*(x21 + 0x28) == x8)
    return zx.q(x20.d)

__stack_chk_fail()
noreturn
