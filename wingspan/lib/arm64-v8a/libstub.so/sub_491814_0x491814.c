// 函数: sub_491814
// 地址: 0x491814
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x0 = sub_4918fc()
void* x20 = *x0

if (x20 != 0)
    int64_t x22_1 = *(x20 + 0x60) & 0xffffffffffffff00
    
    if (x22_1 != 0x434c4e47432b2b00)
        *x0 = 0
    else
        *(x20 + 0x38) = neg.d(*(x20 + 0x38))
        *(x0 + 8) += 1
    
    sub_4a8868(x20 + 0x60)
    int64_t x23_1 = *(x20 + 0x60)
    void* x0_2 = sub_4918fc()
    
    if ((x23_1 & 0xffffffffffffff00) == 0x434c4e47432b2b00)
        int32_t x9_1 = *(x20 + 0x38)
        int32_t x9_2
        
        if (x9_1 s< 0)
            x9_2 = neg.d(x9_1)
        else
            x9_2 = x9_1
        
        *(x20 + 0x38) = x9_2 + 1
        int64_t x9_4 = *x0_2
        
        if (x9_4 != x20)
            *(x20 + 0x30) = x9_4
            *x0_2 = x20
        
        *(x0_2 + 8) -= 1
        
        if (x22_1 == 0x434c4e47432b2b00)
            sub_4919ac(*(x20 + 0x28))
            noreturn
    else if (*x0_2 == 0)
        *x0_2 = x20
        
        if (x22_1 == 0x434c4e47432b2b00)
            sub_4919ac(*(x20 + 0x28))
            noreturn

sub_491944()
noreturn
