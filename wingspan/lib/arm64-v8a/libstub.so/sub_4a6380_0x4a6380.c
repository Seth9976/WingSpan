// 函数: sub_4a6380
// 地址: 0x4a6380
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x20 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x20 + 0x28)
size_t size

size = arg1 != 0 ? arg1 : 1

void* memptr
void* result

if (posix_memalign(&memptr, 0x10, size) == 0)
    result = memptr
else
    result = sub_4a63ec(size)

if (*(x20 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
