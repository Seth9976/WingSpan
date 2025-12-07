// 函数: sub_46428c
// 地址: 0x46428c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_80 = 0
int64_t var_78 = 0
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result
char* const x1_8
char* const x2_4

if ((arg5 & 0x80000000) != 0)
    x1_8 = "java/lang/NegativeArraySizeException"
    x2_4 = "negative array size"
label_46448c:
    sub_45bac8(arg1, x1_8, x2_4)
labelid_8:
    result = 0
else
    int64_t x0_2 = (*(*arg1 + 0x588))(arg1, zx.q(arg5))
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
    labelid_8:
        result = 0
    else
        int16_t var_70
        int64_t x1_4
        
        if (arg5 s>= 1)
            if (x0 == 0)
            label_4644cc:
                x1_8 = "java/lang/NullPointerException"
                x2_4 = "NullPointerException"
                goto label_46448c
            
            int32_t x25_1 = 0
            
            while (true)
                (*(*arg1 + 0x650))(arg1, x0, zx.q(arg4 + x25_1), 1, &var_70)
                int16_t x27_1 = var_70
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_464490_1
                
                if (x0_2 == 0)
                    goto label_4644cc
                
                var_70 = x27_1 ^ arg6
                (*(*arg1 + 0x688))(arg1, x0_2, zx.q(x25_1), 1, &var_70)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_464490_1
                
                x25_1 += 1
                
                if (arg5 == x25_1)
                    x1_4 = var_78
                    
                    if (x1_4 != 0)
                        break
                    
                    goto label_4643c8
            
            goto label_4643e0
        
    label_4643c8:
        
        if ((sub_45bc9c(arg1, &var_78, "java/lang/String") & 1) != 0)
        labelid_8:
            result = 0
        else
            x1_4 = var_78
        label_4643e0:
            int64_t result_1 = (*(*arg1 + 0xd8))(arg1, x1_4)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            label_464490:
                result = 0
            else
                if (result_1 == 0)
                    goto label_4644cc
                
                int64_t x2_2 = var_80
                
                if (x2_2 != 0)
                    goto label_464440
                
                if ((sub_45be5c(arg1, &var_78, &var_80, 0, "java/lang/String", "<init>", "([C)V")
                    & 1) != 0)
                label_464490_1:
                    result = 0
                else
                    x2_2 = var_80
                label_464440:
                    var_70.q = x0_2
                    (*(*arg1 + 0x1f8))(arg1, result_1, x2_2, &var_70)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                        result = result_1
                    else
                        result = 0

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
