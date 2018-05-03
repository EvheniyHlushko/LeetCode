﻿using System.Collections.Generic;

namespace SerializeAndDeserializeBinaryTree_297
{
  public static class QueueExtensions
  {
    public static IEnumerable<T> DequeueChunk<T>(this Queue<T> queue, int chunkSize)
    {
      for (var i = 0; i < chunkSize && queue.Count > 0; i++) yield return queue.Dequeue();
    }
  }
}