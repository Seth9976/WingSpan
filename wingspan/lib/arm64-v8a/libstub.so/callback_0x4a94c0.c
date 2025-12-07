// 函数: callback
// 地址: 0x4a94c0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int32_t x13 = arg2 u> 0x2f ? 1 : 0
struct Elf64_Phdr* dlpi_phdr = arg1->dlpi_phdr
uint64_t dlpi_addr = arg1->dlpi_addr
int64_t* x4_1
int64_t* x5_1
struct Elf64_Phdr* dlpi_phdr_1

if (x13 != 0 && *(arg3 + 0x28) != 0)
    uint64_t dlpi_adds = arg1->dlpi_adds
    uint64_t dlpi_subs = arg1->dlpi_subs
    
    if (dlpi_adds == data_4b0c48 && dlpi_subs == data_4b1038)
        int64_t* x9_2 = data_4b1040
        x4_1 = nullptr
        x5_1 = nullptr
        int64_t* x1 = x9_2
        
        while (true)
            if (x1 == 0)
                goto label_4a95f0
            
            int64_t x10_1 = *arg3
            int64_t x8_1 = *x1
            int64_t x4_2 = x1[1]
            
            if (x10_1 u>= x8_1 && x10_1 u< x4_2)
                dlpi_addr = x1[2]
                dlpi_phdr_1 = x1[3]
                
                if (x1 != x9_2)
                    x5_1[5] = x1[5]
                    x1[5] = x9_2
                    data_4b1040 = x1
                
                break
            
            if ((x8_1 | x4_2) == 0)
                x4_1 = x1
                goto label_4a95f0
            
            int64_t* x8_2 = x1[5]
            x4_1 = x1
            
            if (x8_2 != 0)
                x5_1 = x1
            
            x1 = x8_2
        
        goto label_4a96d0
    
    data_4b0c48 = dlpi_adds
    void* i = &data_4b1078
    data_4b1038 = dlpi_subs
    
    do
        *(i - 0x30) = 0
        *(i - 0x28) = 0
        *(i - 8) = i
        i += 0x30
    while (i != &data_4b11f8)
    
    data_4b11c0 = 0
    data_4b1040 = &data_4b1048
    *(arg3 + 0x28) = 0
else if (arg2 u<= 0x19)
    return -1

x4_1 = nullptr
x5_1 = nullptr
label_4a95f0:
uint64_t dlpi_phnum = zx.q(arg1->dlpi_phnum)
uint64_t x9_3 = 0
uint64_t x10_2 = 0
int64_t x12_1 = 0
struct Elf64_Phdr* dlpi_phdr_2 = nullptr
dlpi_phdr_1 = nullptr

while (true)
    dlpi_phnum -= 1
    
    if (dlpi_phnum == -1)
        break
    
    uint32_t p_type = dlpi_phdr->p_type
    
    if (p_type == 1)
        int64_t x3_3 = *arg3
        uint64_t x1_2 = dlpi_addr + dlpi_phdr->p_vaddr
        
        if (x3_3 u>= x1_2)
            uint64_t x0_2 = x1_2 + dlpi_phdr->p_memsz
            
            if (x3_3 u< x0_2)
                x9_3 = x0_2
            
            if (x3_3 u< x0_2)
                x10_2 = x1_2
            
            if (x3_3 u< x0_2)
                x12_1 = 1
    else if (p_type == 0x6474e550)
        dlpi_phdr_1 = dlpi_phdr
    else if (p_type == 2)
        dlpi_phdr_2 = dlpi_phdr
    
    dlpi_phdr = &dlpi_phdr[1]

if (x12_1 != 0)
    if (x13 != 0)
        if (x5_1 != 0 && x4_1 != 0)
            x5_1[5] = x4_1[5]
            x4_1[5] = data_4b1040
            data_4b1040 = x4_1
        
        int64_t* x0_3 = data_4b1040
        x0_3[2] = dlpi_addr
        x0_3[3] = dlpi_phdr_1
        x0_3[4] = dlpi_phdr_2
        *x0_3 = x10_2
        x0_3[1] = x9_3
    
label_4a96d0:
    
    if (dlpi_phdr_1 != 0)
        uint64_t p_vaddr = dlpi_phdr_1->p_vaddr
        uint64_t x21_1 = dlpi_addr + p_vaddr
        
        if (zx.d(*(dlpi_addr + p_vaddr)) == 1)
            char x20_1 = *(x21_1 + 1)
            int32_t* var_40
            void* x0_8 = sub_4a90d4(x20_1, sub_4a9074(x20_1, arg3), x21_1 + 4, &var_40)
            uint32_t x20_2 = zx.d(*(x21_1 + 2))
            int64_t var_38
            int64_t var_30
            
            if (x20_2 == 0xff || zx.d(*(x21_1 + 3)) != 0x3b)
            label_4a9848:
                int64_t var_28_1 = *(arg3 + 8)
                int64_t var_20_1 = *(arg3 + 0x10)
                int32_t* x1_11 = var_40
                int64_t var_10_1 = 0
                int64_t x2_14 = *arg3
                var_10_1.b = 4
                var_30 = 0
                int32_t* var_18_1 = x1_11
                int32_t* x0_29 = sub_4a9350(&var_30, x1_11, x2_14)
                *(arg3 + 0x20) = x0_29
                
                if (x0_29 != 0)
                    char x0_30 = sub_4a94b0(x0_29)
                    sub_4a90d4(x0_30, sub_4a9074(x0_30, arg3), *(arg3 + 0x20) + 8, &var_38)
                    *(arg3 + 0x18) = var_38
            else
                void* x0_13 = sub_4a90d4(x20_2.b, sub_4a9074(x20_2.b, arg3), x0_8, &var_38)
                int64_t x0_14 = var_38
                
                if (x0_14 != 0)
                    if ((x0_13 & 3) != 0)
                        goto label_4a9848
                    
                    int64_t x1_9 = *arg3
                    
                    if (x1_9 u>= x21_1 + sx.q(*x0_13))
                        uint64_t x0_15 = x0_14 - 1
                        
                        if (x1_9 u< x21_1 + sx.q(*(x0_13 + (x0_15 << 3))))
                            uint64_t x3_7 = x0_15
                            int64_t x4_4 = 0
                            
                            while (true)
                                if (x4_4 u>= x3_7)
                                    abort()
                                    noreturn
                                
                                x0_15 = (x3_7 + x4_4) u>> 1
                                uint64_t x2_8 = x0_15 << 3
                                
                                if (x1_9 u< x21_1 + sx.q(*(x0_13 + x2_8)))
                                    x3_7 = x0_15
                                else
                                    x4_4 = x0_15 + 1
                                    
                                    if (x1_9 u< x21_1 + sx.q(*(x0_13 + x2_8 + 8)))
                                        break
                        
                        uint64_t x20_3 = x0_15 << 3
                        void* x23_2 = x21_1 + sx.q(*(x0_13 + x20_3 + 4))
                        char x0_19 = sub_4a94b0(x23_2)
                        sub_4a90d4(x0_19 & 0xf, nullptr, x23_2 + zx.q(sub_4a8fb4(x0_19)) + 8, 
                            &var_30)
                        void* x21_2 = x21_1 + sx.q(*(x0_13 + x20_3))
                        
                        if (*arg3 u< x21_2 + var_30)
                            *(arg3 + 0x20) = x23_2
                        
                        *(arg3 + 0x18) = x21_2
        
        return 1

return 0
