package pro.javadev.common.recognizer;

import pro.javadev.common.Priority;

import java.util.Optional;

public interface Recognizer<R, T> extends Priority {
    Optional<R> recognize(T subject);
}
