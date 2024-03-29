/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnosql.artemis.jnosql.hazelcast;

import com.hazelcast.core.Hazelcast;
import java.util.Optional;
import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueConfiguration;
import org.jnosql.diana.api.key.KeyValueEntity;
import org.jnosql.diana.hazelcast.key.HazelcastKeyValueConfiguration;

/**
 *
 * @author WayneHu
 */
public class KeyValueApp {
    private static final String BUCKET_NAME = "books";

    public static void main(String... args) throws Exception {
        KeyValueConfiguration configuration = new HazelcastKeyValueConfiguration();
        try (BucketManagerFactory managerFactory = configuration.get()) {
            BucketManager manager = managerFactory.getBucketManager(BUCKET_NAME);

            Book book = new Book("12345", "JNoSQL in Action", "baeldung", 420);
            KeyValueEntity keyValueEntity = KeyValueEntity.of(book.getIsbn(), book);
            manager.put(keyValueEntity);

            Optional<Value> optionalValue = manager.get("12345");
            Value value = optionalValue.get();
            Book savedBook = value.get(Book.class);
            System.out.println("savedBook="+savedBook);
        }
        Hazelcast.shutdownAll();
    }
}
