// 函数: sub_49b614
// 地址: 0x49b614
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x21 = zx.d(*(arg1 + 0xc))
int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
size_t x20

x20 = x21 == 0 ? 5 : 4

int64_t bytes_2 = x8 + x20
int64_t x0

if (bytes_2 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_1 = x10 << 1
    int64_t bytes
    
    bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 == 0)
        sub_491944()
        noreturn
    
    x8 = arg2[1]
else
    x0 = *arg2

char* const x1

if (x21 == 0)
    x1 = "false"
else
    x1 = "true"

int64_t result = memmove(x0 + x8, x1, x20)
arg2[1] += x20
return result
