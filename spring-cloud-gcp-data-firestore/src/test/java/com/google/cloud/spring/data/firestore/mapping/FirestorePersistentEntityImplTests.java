/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spring.data.firestore.mapping;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.cloud.spring.data.firestore.Document;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.ClassTypeInformation;

/** Tests for {@link FirestorePersistentEntityImpl}. */
class FirestorePersistentEntityImplTests {

  @Test
  void testSetCollectionName() {
    FirestorePersistentEntity<Student> firestorePersistentEntity =
        new FirestorePersistentEntityImpl<>(ClassTypeInformation.from(Student.class));
    assertThat(firestorePersistentEntity.collectionName()).isEqualTo("student");
  }

  @Test
  void testInferCollectionName() {
    FirestorePersistentEntity<Employee> firestorePersistentEntity =
        new FirestorePersistentEntityImpl<>(ClassTypeInformation.from(Employee.class));
    assertThat(firestorePersistentEntity.collectionName()).isEqualTo("employee_table");
  }

  @Document
  private static class Student {}

  @Document(collectionName = "employee_table")
  private static class Employee {}
}
