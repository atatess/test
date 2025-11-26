// A) hashCode() for Course
class Course {
    String name;
    int code;
    String classroom;

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + code;
        result = 31 * result + (classroom == null ? 0 : classroom.hashCode());
        return result;
    }
}

// B) Linear probing hash table (size 10) inserting:
// Keys: 12, 17, 2, 3, 14, 4, 5, 8, 1
//
// Hash function: key % 10
//
// Insert sequence:
//
// 12 → index 2
// 17 → index 7
// 2  → index 2 (taken) → 3 empty → place at 3
// 3  → index 3 (taken) → 4 empty → place at 4
// 14 → index 4 (taken) → 5 empty → place at 5
// 4  → index 4 (taken) → 5 (taken) → 6 empty → place at 6
// 5  → index 5 (taken) → 6 (taken) → 7 (taken) → 8 empty → place at 8
// 8  → index 8 (taken) → 9 empty → place at 9
// 1  → index 1 empty → place at 1
//
// Final table:
//
// Index : Key
// 0 : -
// 1 : 1
// 2 : 12
// 3 : 2
// 4 : 3
// 5 : 14
// 6 : 4
// 7 : 17
// 8 : 5
// 9 : 8

// C) Searching for key 4:
//
// hash = 4 % 10 = 4
// Compare in order:
//
// index 4 → key = 3 ≠ 4  
// index 5 → key = 14 ≠ 4  
// index 6 → key = 4 ✓ found
//
// Sequence compared: 3, 14, 4
