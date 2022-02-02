import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
//        for (int i = 0; i < size; i++) {                                            * Если такой uuid
//            if (storage[i].uuid.equals(resume.uuid)) {                              * уже существует
//                System.out.println("This UUID already exists by number " + i);
//                return;
//            }
//        }
        storage[size++] = resume;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.out.print("Number " + i + " ");
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {
        if (uuid == null) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                if ((size - 1) - i >= 0) {
                    System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                }
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
