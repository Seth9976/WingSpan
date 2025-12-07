// 函数: sub_4889f8
// 地址: 0x4889f8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_98
__builtin_memset(&var_98, 0, 0x48)
int64_t x0 = (*(*arg1 + 0xc8))()
(*(*arg1 + 0xc8))(arg1, arg3)
int32_t result
uint64_t x20_1

if (x0 == 0)
label_488cd8:
    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
label_488cdc:
    x20_1 = 0
label_488cec:
    uint64_t x0_34 = (*(*arg1 + 0x78))(arg1)
    (*(*arg1 + 0x88))(arg1)
    result = sub_45bb84(arg1, x0_34, "java/lang/NullPointerException")
    
    if ((result & 1) == 0)
        (*(*arg1 + 0x68))(arg1, x0_34)
        result = (*(*arg1 + 0xb8))(arg1, x0_34)
    else if (x20_1 != 0)
        result = (*(*arg1 + 0xb8))(arg1, x20_1)
else
    int64_t var_78
    int64_t var_58
    
    if ((sub_45c03c(arg1, &var_58, &var_78, 0, "apkvision/sVMbOPAtE$1$2", "this$0", 
            "Lapkvision/sVMbOPAtE$1;") & 1) != 0)
        goto label_488cdc
    
    x20_1 = (*(*arg1 + 0x2f8))(arg1, x0, var_78)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_488cdc
    
    if (x20_1 == 0)
    label_488d94:
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        goto label_488cec
    
    int64_t var_80
    int64_t x2_2 = var_80
    
    if (x2_2 != 0)
        goto label_488b14
    
    int64_t var_60
    
    if ((sub_45c03c(arg1, &var_60, &var_80, 0, "apkvision/sVMbOPAtE$1", "val$activity", 
            "Landroid/app/Activity;") & 1) != 0)
        goto label_488cec
    
    x2_2 = var_80
label_488b14:
    uint64_t x0_11 = (*(*arg1 + 0x2f8))(arg1, x20_1, x2_2)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_488cec
    
    (*(*arg1 + 0xb8))(arg1, x20_1)
    int64_t var_88
    int64_t x2_4 = var_88
    
    if (x2_4 != 0)
        goto label_488b94
    
    if ((sub_45c03c(arg1, &var_58, &var_88, 0, "apkvision/sVMbOPAtE$1$2", "val$idImageView", "I")
        & 1) != 0)
    label_488bb4:
        x20_1 = x0_11
        goto label_488cec
    
    x2_4 = var_88
label_488b94:
    int32_t x0_18 = (*(*arg1 + 0x320))(arg1, x0, x2_4)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_488bb4
    
    if (x0_11 == 0)
        goto label_488cd8
    
    int64_t var_90
    int64_t x2_6 = var_90
    
    if (x2_6 == 0)
        int64_t var_68
        
        if ((sub_45be5c(arg1, &var_68, &var_90, 0, "android/app/Activity", "findViewById", 
                "(I)Landroid/view/View;") & 1) != 0)
            goto label_488bb4
        
        x2_6 = var_90
    
    int32_t var_50 = x0_18
    x20_1 = (*(*arg1 + 0x120))(arg1, x0_11, x2_6, &var_50)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_488bb4
    
    (*(*arg1 + 0xb8))(arg1, x0_11)
    
    if (x20_1 == 0)
        goto label_488d94
    
    int64_t x2_8 = var_98
    
    if (x2_8 != 0)
        goto label_488c8c
    
    int64_t var_70
    
    if ((sub_45be5c(arg1, &var_70, &var_98, 0, "android/view/View", "setVisibility", "(I)V") & 1)
            != 0)
        goto label_488cec
    
    x2_8 = var_98
label_488c8c:
    var_50 = 8
    (*(*arg1 + 0x1f8))(arg1, x20_1, x2_8, &var_50)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) != 0)
        goto label_488cec

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
